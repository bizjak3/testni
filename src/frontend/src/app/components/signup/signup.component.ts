import { Component, OnInit } from '@angular/core';
import { RegisterService } from '../../services/register/register.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  public uporabnik = {
    tip: "",
    ime: '',
    priimek: '',
    uporabniskoIme: '',
    email: '',
    geslo: '',
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

  constructor(private reg: RegisterService) { }

  ngOnInit(): void {
  }

  radioChangeHandler(event: any) {
    console.log(event.target.value);
  }

/*
  {
    name: this.uporabnik.ime,
    surname: this.uporabnik.priimek,
    email: this.uporabnik.email,
    username: this.uporabnik.uporabniskoIme,
    password: this.uporabnik.geslo
  }
  */
  public register() {
    console.log(this.uporabnik);
    if(this.uporabnik.tip == "lastnik"){
      console.log("je lastnik");
      this.reg.registerOwner({
        name: this.uporabnik.ime,
        surname: this.uporabnik.priimek,
        email: this.uporabnik.email,
        username: this.uporabnik.uporabniskoIme,
        password: this.uporabnik.geslo
      });
    }else{
      console.log("ni lastnik");
      this.reg.registerWorker({
        name: this.uporabnik.ime,
        surname: this.uporabnik.priimek,
        email: this.uporabnik.email,
        username: this.uporabnik.uporabniskoIme,
        password: this.uporabnik.geslo
      });
    }

  }

}
