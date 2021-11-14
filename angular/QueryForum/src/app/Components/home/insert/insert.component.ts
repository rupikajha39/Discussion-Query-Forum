import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl,FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-insert',
  templateUrl: './insert.component.html',
  styleUrls: ['./insert.component.css']
})
export class InsertComponent implements OnInit {
  option = ['angular', 'njdsaf', 'dsab', 'dsfhbajs', 'asdhjh'];
  keyword: any;
  topic: any;
  choosenTopic: any;
  newTopic: any;
  newKeyword: any;
  choosenKeyword: any;
  question: any;
  userId: any;
  showTopicError = false;
  showKeywordError = false;
  showQuestionError = false;
  showSuccess = false;
  showError = false;
  dropdownTopic: FormGroup;

  constructor(
    private http: HttpClient,
    private route: Router,
    private fb: FormBuilder
    ) {
      this.dropdownTopic = new FormGroup({
        topicIndex: new FormControl(null)
      });
      this.dropdownTopic.controls.topicIndex.setValue("Topic",{onlySelf:true});
    }

  ngOnInit(): void {
      this.userId = localStorage.getItem('id');
      this.http.get('http://localhost:8080/topic/subscribe/get/' + this.userId).subscribe(data => {
      this.topic = data;
    });

      this.http.get('http://localhost:8080/keyword').subscribe(data => {
      this.keyword = data;
    });

  }

  addTopic(): void{

    if (this.newTopic !== undefined){
      const date = new Date;
      const dates = date.getFullYear() + '/' + date.getMonth() + '/' + date.getDay();
      console.log(dates);
      this.http.post('http://localhost:8080/topic/create',
      {userid: this.userId, topicname: this.newTopic, timestamp: dates})
      .subscribe(data => {
        this.topic.push(data);
      });
    }
    else{
      alert('Enter topic');
    }
  }

  addKeyword(): void{
    if (this.newKeyword !== undefined){
      const date = new Date;
      const dates = date.getFullYear() + '/' + date.getMonth() + '/' + date.getDay();
      console.log(dates);
      this.http.post('http://localhost:8080/keyword/add',
      {userid: this.userId, name: this.newKeyword, timestamp: dates})
      .subscribe(data => {
        this.keyword.push(data);
      });
    }
    else{
      alert('Enter Keyword');
    }
  }
  submit(): void{
    this.showTopicError = false;
    this.showKeywordError = false;
    this.showQuestionError = false;
    this.showSuccess = false;
    this.showError = false;
    const choosenKeywordList = [];
    this.choosenTopic=this.dropdownTopic.value.topicIndex;

    if (this.choosenTopic === undefined){
        this.showTopicError = true;
      }
    if (this.choosenKeyword === undefined){
        this.showKeywordError = true;
      }
      else{
        for (let i = 0; i < this.choosenKeyword.length; i++){
          choosenKeywordList.push({keywordid: this.choosenKeyword[i].id,
             questionid: 0, keywordName: this.choosenKeyword[i].name});
        }
      }
    if (this.question === undefined){
        this.showQuestionError = true;
      }



    if (this.choosenKeyword !== undefined && this.choosenTopic !== undefined && this.question !== undefined){
        const date = new Date;
        const dates = date.getFullYear() + '/' + date.getMonth() + '/' + date.getDay();
        this.http.post('http://localhost:8080/question',
          {
            question: {
            answeredflag : false,
            description : this.question ,
            timestamp : dates,
            userid : this.userId,
            topicid : this.choosenTopic.id
        },
        keywordQuestionList: choosenKeywordList

        }, {responseType: 'text'}).subscribe(data => {
          if (data === 'true'){
            this.showSuccess = true;
            this.http.get('http://localhost:8080/notify/ques/'+this.choosenTopic.id+"/"+
            this.choosenTopic.topicname).subscribe(data=>{
              console.log(data);
            });
          }
          else{
            this.showError = true;
          }
        });
      }
  }


}
