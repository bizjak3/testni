import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToBeDeletedComponent } from './components/to-be-deleted/to-be-deleted.component';
import { ToBeDeletedPipe } from './pipes/to-be-deleted/to-be-deleted.pipe';
import { LoginComponent } from './components/login/login.component';
import { NavbarLoginSignupComponent } from './components/navbars/navbar-login-signup/navbar-login-signup.component';

@NgModule({
  declarations: [
    AppComponent,
    ToBeDeletedComponent,
    ToBeDeletedPipe,
    LoginComponent,
    NavbarLoginSignupComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
