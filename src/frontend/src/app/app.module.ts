import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToBeDeletedPipe } from './pipes/to-be-deleted/to-be-deleted.pipe';
import { LoginComponent } from './components/login/login.component';
import { NavbarLoginSignupComponent } from './components/navbars/navbar-login-signup/navbar-login-signup.component';
import { SignupComponent } from './components/signup/signup.component';
import { DodajPsaComponent } from './components/dodaj-psa/dodaj-psa.component';
import { ZacetnaStranComponent } from './components/zacetna-stran/zacetna-stran.component';
import { DodajanjeStoritveComponent } from './components/dodajanje-storitve/dodajanje-storitve.component';
import { ProfilComponent } from './components/profil/profil.component';
import { PregledStoritevComponent } from './components/pregled-storitev/pregled-storitev.component';
import { FooterComponent } from './components/footer/footer.component';
import { EditProfileComponent } from './components/edit-profile/edit-profile.component';
import { SeznamUporabnikovComponent } from './components/seznam-uporabnikov/seznam-uporabnikov.component';
import { UporabnikComponent } from './components/uporabnik/uporabnik.component';
import { SpremeniUporabnikaComponent } from './components/spremeni-uporabnika/spremeni-uporabnika.component';

@NgModule({
  declarations: [
    AppComponent,
    ToBeDeletedPipe,
    LoginComponent,
    NavbarLoginSignupComponent,
    SignupComponent,
    DodajPsaComponent,
    ZacetnaStranComponent,
    DodajanjeStoritveComponent,
    ProfilComponent,
    PregledStoritevComponent,
    FooterComponent,
    EditProfileComponent,
    SeznamUporabnikovComponent,
    UporabnikComponent,
    SpremeniUporabnikaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule,
    HttpClientModule
  ],
  entryComponents: [SpremeniUporabnikaComponent],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
