import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { BASE_URL } from 'src/app/constants/baseUrl';

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
    this.http.get(BASE_URL + '/notify/'+this.userId).subscribe(data=>{
      this.notificationList=data;
    });
  }

  showNotification(): void{
    this.notifyUser=!this.notifyUser;
  }

}
