import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  loggedIn = false;
  userId = -1;

  constructor() { }

  changeLogin(id: any ): void{
    this.loggedIn = true;
    this.userId = id;
    console.log(this.userId);
  }
}
