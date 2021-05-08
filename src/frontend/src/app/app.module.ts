import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { ToBeDeletedComponent } from './components/to-be-deleted/to-be-deleted.component';
import { ToBeDeletedPipe } from './pipes/to-be-deleted/to-be-deleted.pipe';

@NgModule({
  declarations: [
    AppComponent,
    ToBeDeletedComponent,
    ToBeDeletedPipe
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
