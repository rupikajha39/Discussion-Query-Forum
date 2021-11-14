import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import { BASE_URL } from 'src/app/constants/baseUrl';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})


export class RegisterComponent implements OnInit {



  id = '';
  name = '';
  password = '';
  confirmPassword = '';
  email = '';
  location = '';


  idInvalid = false;
  nameInvalid=false;
  locationInvalid=false;
  emailInvalid=false;
  passwordInvalid=false;
  confirmPasswordInvalid=false;
  emailWrong=false;
  passwordUnmatched=false;
  buttonMessage=false;

  constructor(
    private http: HttpClient,
    private route: Router,
  ) { }

  ngOnInit(): void {
  }

  register(): void{
    this.idInvalid = false;
    this.nameInvalid = false;
  this.locationInvalid=false;
  this.emailInvalid=false;
  this.passwordInvalid=false;
  this.confirmPasswordInvalid=false;
  this.emailWrong=false;
  this.passwordUnmatched=false;
  this.buttonMessage=false;

    if(this.id===''){
      this.idInvalid=true;
    }
    if(this.name===''){
      this.nameInvalid=true;
    }

    if(this.location===''){
      this.locationInvalid=true;
    }

    if(this.email===''){
      this.emailInvalid=true;
    }

    if(this.password===''){
      this.passwordInvalid=true;
    }

    if(this.confirmPassword===''){
      this.confirmPasswordInvalid=true;
    }

    if ( this.password !== this.confirmPassword){
      this.passwordUnmatched=true;
    }

    if (this.email.includes("@accolitedigital.com")===false){
      this.emailWrong=true;
    }

    if(this.id!=='' && this.email!=='' && this.name!==''
    && this.location !=='' && this.password!=='' && this.confirmPassword!=='' && this.email.includes("@accolitedigital.com"))
    {
    this.http.post(BASE_URL + '/register', {id: this.id, name: this.name,
    email: this.email, password: this.password, location: this.location}, {responseType: 'text'})
    .subscribe(data  => {
      if(data=='User inserted into table'){
        alert("Going Back to Login Page");
        this.route.navigateByUrl('/login');
      }
      else if( data==='Error'){
        alert("Try again");
      }
      else{
        this.buttonMessage=true;
      }
    });
  }
  }



}
