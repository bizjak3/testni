import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ErrorWrapper } from 'src/app/models/error/ErrorWrapper';
import { RegisterService } from '../../services/register/register.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss'],
})
export class SignupComponent implements OnInit {
  model = 1;

  public uporabnik = {
    tip: 'lastnik',
    ime: '',
    priimek: '',
    uporabniskoIme: '',
    email: '',
    geslo: '',
    geslo1: ''
  };
  submitted = false;
  emptyPassword = true;
  username = '';
  showSuccess = false;
  //isOnline = false; // to bila funkcija
  public napakaNaObrazcu = '';

  public kajJe() {
    console.log(this.uporabnik.tip ? 'lastnik' : 'izvajalec');
  }

  constructor(
    private reg: RegisterService,
    private router: Router,
    private activatedRoute: ActivatedRoute
  ) {
    activatedRoute.params.subscribe((params) => {
      console.log(params);
      if (params.tip) this.uporabnik.tip = params.tip;
    });
  }

  ngOnInit(): void {}

  radioChangeHandler(event: any) {
    console.log(event.target.value);
  }

  public register() {
    console.log(this.uporabnik);
    if (this.vsaPolna()) {
      if (this.gesliEnaki()) {
        if (this.uporabnik.tip === 'lastnik') {
          console.log('je lastnik');
          this.reg
            .registerOwner({
              name: this.uporabnik.ime,
              surname: this.uporabnik.priimek,
              email: this.uporabnik.email,
              username: this.uporabnik.uporabniskoIme,
              password: this.uporabnik.geslo,
            })
            .subscribe(
              (data) => {
                alert('Registracija uspešna, lahko se prijavite');
                this.router.navigate(['/login']);
              },
              (err: HttpErrorResponse) => {
                const errorWrapper = err.error as ErrorWrapper;
                //naredi nekaj z errorji
                errorWrapper.errors.forEach((napaka) => {
                  this.napakaNaObrazcu = napaka + '\n';
                });
                console.log(errorWrapper);
              }
            );
        } else {
          console.log('ni lastnik');
          this.reg
            .registerWorker({
              name: this.uporabnik.ime,
              surname: this.uporabnik.priimek,
              email: this.uporabnik.email,
              username: this.uporabnik.uporabniskoIme,
              password: this.uporabnik.geslo,
            })
            .subscribe(
              (data) => {
                alert('Registracija uspešna, lahko se prijavite');
                this.router.navigate(['/login']);
              },
              (err: HttpErrorResponse) => {
                const errorWrapper = err.error as ErrorWrapper;
                //naredi nekaj z errorji
                errorWrapper.errors.forEach((napaka) => {
                  this.napakaNaObrazcu = napaka + '\n';
                });
              }
            );
        }
      } else {
        this.napakaNaObrazcu = 'Gesli marata biti enaki\n';
      }
    }
  }

  public vsaPolna(): boolean {
    // tslint:disable-next-line:max-line-length
    if (
      this.uporabnik.ime === '' ||
      this.uporabnik.priimek === '' ||
      this.uporabnik.uporabniskoIme === '' ||
      this.uporabnik.email === '' ||
      this.uporabnik.geslo === ''
    ) {
      this.napakaNaObrazcu = 'Vsa polja morajo biti izpolnjena\n';
      return false;
    }
    return true;
  }

  public gesliEnaki(): boolean {
    if (this.uporabnik.geslo === this.uporabnik.geslo1) {
      return true;
    }
    return false;
  }
}
