import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { DodajPsaComponent } from './components/dodaj-psa/dodaj-psa.component';
import { ZacetnaStranComponent } from './components/zacetna-stran/zacetna-stran.component';
import { DodajanjeStoritveComponent } from './components/dodajanje-storitve/dodajanje-storitve.component';
import { ProfilComponent } from './components/profil/profil.component';

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
    path: 'dodaj_psa',
    component: DodajPsaComponent,
    canActivate: [LoginComponent],
  },
  {
    path: 'dodaj_storitev',
    component: DodajanjeStoritveComponent,
    canActivate: [LoginComponent],
  },
  {
    path: 'profil',
    component: ProfilComponent,
    canActivate: [LoginComponent],
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
