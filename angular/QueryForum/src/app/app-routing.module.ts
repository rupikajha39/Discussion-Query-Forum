import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './Components/home/home.component';
import { TopicComponent } from './Components/home/topic/topic.component';
import { LoginComponent } from './Components/login/login.component';
import { RegisterComponent } from './Components/register/register.component';
import {InsertComponent} from './Components/home/insert/insert.component';
import { AnswerComponent } from './Components/home/answer/answer.component';
import { UserComponent } from './Components/home/user/user.component';

const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'home', component: HomeComponent},
  {path: 'home/topic', component: TopicComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'home/questions/insert', component: InsertComponent},
  {path: 'home/questions/answer', component: AnswerComponent},
  {path: 'user', component: UserComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
export const routingComponents = [LoginComponent, RegisterComponent, HomeComponent, TopicComponent, InsertComponent, AnswerComponent];
