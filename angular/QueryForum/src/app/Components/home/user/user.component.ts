import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
  Branch = '';


  idInvalid = false;
  nameInvalid=false;
  BranchInvalid=false;
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
    this.http.get('http://localhost:8080/user/details/'+this.userId).subscribe(data=>{
        user =data;
        console.log(user);
        this.id=user.id;
        this.name=user.name;
        this.Branch=user.Branch;
        this.email=user.email;
        this.password=user.password;
        this.confirmPassword=user.password;

    });

  }

  saveChanges(): void{
    console.log(this.Branch);
    this.idInvalid = false;
    this.nameInvalid = false;
    this.BranchInvalid=false;
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

    if(this.Branch===''){
      this.BranchInvalid=true;
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

    if (this.email.includes("@lpu.in")===false){
      this.emailWrong=true;
    }

    if(this.id!=='' && this.email!=='' && this.name!==''
    && this.Branch !=='' && this.password!=='' || this.confirmPassword!=='' && this.email.includes("@lpu.in"))
    {
    console.log(this.id, this.name, this.email,  this.password, this.Branch);
    this.http.put('http://localhost:8080/user/update', {id: this.id, name: this.name,
    email: this.email, password: this.password, location: this.Branch}, {responseType: 'text'})
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
