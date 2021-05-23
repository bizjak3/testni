import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { DodajPsaComponent } from './components/dodaj-psa/dodaj-psa.component';
import { ZacetnaStranComponent } from './components/zacetna-stran/zacetna-stran.component';
import { DodajanjeStoritveComponent } from './components/dodajanje-storitve/dodajanje-storitve.component';
import { ProfilComponent } from './components/profil/profil.component';
import { LoginService } from './services/login/login.service';
import { PregledStoritevComponent } from './components/pregled-storitev/pregled-storitev.component';
import { EditProfileComponent} from './components/edit-profile/edit-profile.component';
import {SeznamUporabnikovComponent} from './components/seznam-uporabnikov/seznam-uporabnikov.component';
import {PublicProfileComponent} from './components/public-profile/public-profile.component';

const routes: Routes = [
  {
    path: '',
    component: ZacetnaStranComponent,
  },
  {
    path: 'login',
    component: LoginComponent,
  },
  {
    path: 'signup',
    component: SignupComponent,
  },
  {
    path: 'signup/:tip',
    component: SignupComponent,
  },
  {
    path: 'dodaj_psa',
    component: DodajPsaComponent,
    canActivate: [LoginService],
  },
  {
    path: 'dodaj_storitev',
    component: DodajanjeStoritveComponent,
    canActivate: [LoginService],
  },
  {
    path: 'profil',
    component: ProfilComponent,
    canActivate: [LoginService],
  },
  {
    path: 'profile/:username',
    component: PublicProfileComponent
  },
  {
    path: 'pregled_storitev',
    component: PregledStoritevComponent,
    canActivate: [LoginService],
  },
  {
    path: 'spremeni_profil',
    component: EditProfileComponent
  },
  {
    path: 'seznam_uporabnikov',
    component: SeznamUporabnikovComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
