import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

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
    console.log(this.location);
    this.idInvalid = false;
    this.nameInvalid = false;
  this.locationInvalid=false;
  this.emailInvalid=false;
  this.passwordInvalid=false;
  this.confirmPasswordInvalid=false;
  this.emailWrong=false;
  this.passwordUnmatched=false;
  this.buttonMessage=false;

    console.log("fje");

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
      console.log("fdsnbvh");
      this.passwordUnmatched=true;
    }

    if (this.email.includes("@lpu.in")===false){
      this.emailWrong=true;
    }

    if(this.id!=='' && this.email!=='' && this.name!==''
    && this.location !=='' && this.password!=='' && this.confirmPassword!=='' && this.email.includes("@lpu.in"))
    {
    console.log(this.id, this.name, this.email,  this.password, this.location);
    this.http.post('http://localhost:8080/register', {id: this.id, name: this.name,
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
