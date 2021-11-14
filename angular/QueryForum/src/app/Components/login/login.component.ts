import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {DataService} from '../../data.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  id = '';
  password = '';
  idInvalid = false;
  passwordInvalid=false;
  passwordWrong=false;
  buttonMessage=false;

  constructor(
    private http: HttpClient,
    private route: Router
  ) { }

  ngOnInit(): void {

  }

  login(): void{

    this.idInvalid=false;
    this.buttonMessage=false;
    this.passwordInvalid=false;
    this.passwordWrong=false;

    if(this.id==='' ){
      this.idInvalid=true;
    }
    if (this.password===''){
      this.passwordInvalid=true;
    }

    if(this.id !=='' && this.password !=='' )
    {
    this.http.post('http://localhost:8080/login', { id: this.id, password: this.password},
    {responseType: 'text'}).subscribe((data) =>
     {
        if(data === 'User matched'){

          localStorage.setItem('id', this.id);
          this.route.navigateByUrl('/home');

        }
        else if(data==='Incorrect password'){
          this.passwordWrong = true;
        }
        else{
            this.buttonMessage=true;
        }
    });
  }
}

}
