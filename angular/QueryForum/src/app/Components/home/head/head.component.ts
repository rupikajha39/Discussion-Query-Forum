import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-head',
  templateUrl: './head.component.html',
  styleUrls: ['./head.component.css']
})
export class HeadComponent implements OnInit {

  notificationList: any;
  userId: any;
  notifyUser=false;

  constructor(
    private http: HttpClient
  ) { }

  ngOnInit(): void {
    this.userId=localStorage.getItem('id');
    this.http.get('http://localhost:8080/notify/'+this.userId).subscribe(data=>{
      this.notificationList=data;
    });
  }

  showNotification(): void{
    this.notifyUser=!this.notifyUser;
  }

}
