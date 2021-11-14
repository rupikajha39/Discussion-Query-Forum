import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {DataService} from '../../../data.service';
import { BASE_URL } from 'src/app/constants/baseUrl';

@Component({
  selector: 'app-topic',
  templateUrl: './topic.component.html',
  styleUrls: ['./topic.component.css']
})
export class TopicComponent implements OnInit {

  subTopics: any;
  unSubTopics: any;
  allTopics: any;
  id: any;

  constructor(
    private http: HttpClient,
    private service: DataService
  ) { }

  ngOnInit(): void {
    this.id = localStorage.getItem('id');

    this.http.get(BASE_URL + '/topic/subscribe/get/' + this.id).subscribe(data => {
      this.subTopics = data;
    });

    this.http.get(BASE_URL + '/topic/unsubscribe/get/' + this.id).subscribe(data => {
      this.unSubTopics = data;
    });

  }




   unSub(index: any): void{
     const topics = this.subTopics.splice(index, 1);
     this.unSubTopics.push(...topics);
   }

   sub(index: any): void{
      const topics = this.unSubTopics.splice(index, 1);
      this.subTopics.push(...topics);
   }

   submit(): void{
     this.http.post(BASE_URL + '/topic/subscribe/' + this.id , this.subTopics,
     {responseType: 'text'}).subscribe(data => {
       if (data === 'true'){
         alert('Changes saved');
       }
       else{
         alert('Refresh the page and try again');
       }
     });

   }

}
