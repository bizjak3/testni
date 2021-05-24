import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {LoginService} from '../../services/login/login.service';
import {DogoService} from '../../services/dogo/dogo.service';
import {ErrorWrapper} from 'src/app/models/error/ErrorWrapper';
import {HttpErrorResponse} from '@angular/common/http';
import {DogApiBreed} from '../../models/dog_api_breed';

@Component({
  selector: 'app-dodaj-psa',
  templateUrl: './dodaj-psa.component.html',
  styleUrls: ['./dodaj-psa.component.scss']
})
export class DodajPsaComponent implements OnInit {

  public errors;

  public pes = {
    ime: '',
    pasma: '',
    komentarji: ''
  };

  public breeds: DogApiBreed[];
  public loading: boolean = false;

  constructor(private login: LoginService, private dogo: DogoService,
              private router: Router) {
    this.loading = true;
    this.getBreeds();
  }

  private async getBreeds(): Promise<void> {
    this.loading = true;
    (await this.dogo.getBreeds()).subscribe(data => {
      this.breeds = data;
      this.loading = false;
    }, (err: HttpErrorResponse) => {
      this.errors = (err.error as ErrorWrapper).errors;
      this.loading = false;
    });
  }

  ngOnInit(): void {
  }

  public async dodajPsa() {
    this.errors = [];

    if (this.pes.ime == '') {
      this.errors.push('Ime ne sme biti prazno');
    }
    if (this.pes.pasma == '') {
      this.errors.push('Pasma ne sme biti prazna');
    }

    if (this.errors.length == 0) {
      const obs = await this.dogo
        .addDogoPost({
          id: null,
          name: this.pes.ime,
          breed: this.pes.pasma,
          breedId: 0,
          owner: this.login.userLoggedIn,
        });
      obs.subscribe(
        (data) => {
          alert('Dogo dodan!');
          this.router.navigate(['/pregled_storitev']);
        },
        (err: HttpErrorResponse) => {
          const errorWrapper = err.error as ErrorWrapper;
          //naredi nekaj z errorji
          this.errors = errorWrapper.errors;
        }
      );
    }
  }

}
