import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BASE_URL } from 'src/app/constants/baseUrl';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

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
  userId: any;


  constructor(
    private http: HttpClient,
    private route: Router,
  ) { }

  ngOnInit(): void {
    let user: any;

    this.userId=localStorage.getItem('id');
    this.http.get(BASE_URL + '/user/details/'+this.userId).subscribe(data=>{
        user =data;
        this.id=user.id;
        this.name=user.name;
        this.location=user.location;
        this.email=user.email;
        this.password=user.password;
        this.confirmPassword=user.password;

    });

  }

  saveChanges(): void{
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
    && this.location !=='' && this.password!=='' || this.confirmPassword!=='' && this.email.includes("@accolitedigital.com"))
    {
    this.http.put(BASE_URL + '/user/update', {id: this.id, name: this.name,
    email: this.email, password: this.password, location: this.location}, {responseType: 'text'})
    .subscribe(data  => {
      if(data=='true'){
        this.buttonMessage=true;
      }

      else{
        alert("Error occured.");
      }
    });
  }
  }

}
