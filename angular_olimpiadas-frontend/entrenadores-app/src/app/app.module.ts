import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import {HeaderComponent} from "./header/header.component";
import {FooterComponent} from "./footer/footer.component";
import { DirectivaComponent } from './directiva/directiva.component';
import { CompetidoresComponent } from './competidores/competidores.component';
import {CompetidorService} from "./competidores/competidor.service";

import {RouterModule, Routes} from "@angular/router";
import {HttpClientModule} from '@angular/common/http';
import { FormComponent } from './competidores/form.component';
import {FormsModule} from "@angular/forms";
import { LoginComponent } from './usuarios/login.component';
import {AuthService} from "./usuarios/auth.service";

const routes: Routes =[
  {path: '', redirectTo: './competidores', pathMatch: 'full'},
  {path: 'directivas', component: DirectivaComponent},
  {path: 'competidores', component: CompetidoresComponent},
  {path: 'competidores/form', component: FormComponent},
  {path: 'competidores/form/:id', component: FormComponent},
  {path: 'login', component: LoginComponent}
];

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent,
    DirectivaComponent,
    CompetidoresComponent,
    FormComponent,
    LoginComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
    HttpClientModule,
    FormsModule
  ],
  providers: [CompetidorService],
  bootstrap: [AppComponent]
})
export class AppModule { }
