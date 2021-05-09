import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToBeDeletedComponent } from './components/to-be-deleted/to-be-deleted.component';
import { ToBeDeletedPipe } from './pipes/to-be-deleted/to-be-deleted.pipe';
import { LoginComponent } from './components/login/login.component';
import { NavbarLoginSignupComponent } from './components/navbars/navbar-login-signup/navbar-login-signup.component';
import { SignupComponent } from './components/signup/signup.component';
import { DodajPsaComponent } from './components/dodaj-psa/dodaj-psa.component';

@NgModule({
  declarations: [
    AppComponent,
    ToBeDeletedComponent,
    ToBeDeletedPipe,
    LoginComponent,
    NavbarLoginSignupComponent,
    SignupComponent,
    DodajPsaComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
