import {Component, Input, OnInit} from '@angular/core';
import {User} from '../../models/user';
import {NgbActiveModal} from '@ng-bootstrap/ng-bootstrap';
import {HttpErrorResponse} from '@angular/common/http';
import {ErrorWrapper} from '../../models/error/ErrorWrapper';
import {UserService} from '../../services/user/user.service';

@Component({
  selector: 'app-spremeni-uporabnika',
  templateUrl: './spremeni-uporabnika.component.html',
  styleUrls: ['./spremeni-uporabnika.component.scss']
})
export class SpremeniUporabnikaComponent implements OnInit {
  @Input() uporabnik: User;
  public nadomestniUporabnik = {
    name: '',
    surname: '',
    username: '',
    email: ''
  };

  constructor(public activeModal: NgbActiveModal, private userService: UserService) { }

  ngOnInit(): void {
    console.log('To je uporabnik v modalu ' + this.uporabnik.name);
  }

  // passBack() {
  //   this.passEntry.emit(this.user);
  //   this.activeModal.close(this.user);
  // }

  public async posodobiUporabnika() {
    this.uporabnik.name = (this.nadomestniUporabnik.name === '' ? this.uporabnik.name : this.nadomestniUporabnik.name);
    this.uporabnik.surname = (this.nadomestniUporabnik.surname === '' ? this.uporabnik.surname : this.nadomestniUporabnik.surname);
    this.uporabnik.username = (this.nadomestniUporabnik.username === '' ? this.uporabnik.username : this.nadomestniUporabnik.username);
    this.uporabnik.email = (this.nadomestniUporabnik.email === '' ? this.uporabnik.email : this.nadomestniUporabnik.email);
    //   .updateUser(this.loginService.userLoggedIn)
    //   .then((data) => {
    //     if (data === true) {
    //       alert('Uporabnik uspešno posodobljen');
    //       this.router.navigate(['/profil']);
    //     } else {
    //       this.napakaNaObrazcu = 'Napaka pri posodabljanju uporabnika';
    //     }
    //   })
    //   .catch(() => (this.napakaNaObrazcu = 'Napaka pri posodabljanju uporabnika'));
    const observable = await this.userService.updateUser(this.uporabnik);
    observable.subscribe((data) => {
      alert('Uporabnik posodobljen');
      // this.router.navigate(['/pregled_storitev']);
    }, (err: HttpErrorResponse) => {
      const errorWrapper: ErrorWrapper = err.error;
      console.log(errorWrapper);
      // errors = errorWrapper.errors
    });
    this.activeModal.close();
  }
}
