import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { BASE_URL } from 'src/app/constants/baseUrl';

@Component({
  selector: 'app-answer',
  templateUrl: './answer.component.html',
  styleUrls: ['./answer.component.css']
})
export class AnswerComponent implements OnInit {

  ques: any;
  answer: any;
  userId: any;
  showInput = false;
  newAnswer: any;
  showError = false;
  showSuccess = false;
  editedAnswer: any;
  show= false;

  constructor(
    private router: Router,
    private http: HttpClient
    )
  {}

  ngOnInit(): void {
    this.userId = localStorage.getItem('id');
    this.http.get(BASE_URL + '/question/answer/' + this.ques.id).subscribe(data => {
      this.answer = data;
    });
  }

  answerInput(): void{
    this.showInput = ! this.showInput;
  }
  saveAnswer(): void{
      this.showError=false;
      this.showSuccess=false;
      if(this.newAnswer===undefined){
          this.showError=true;
      }
      else{
        const date = new Date;
        const dates = date.getFullYear() + '/' + date.getMonth() + '/' + date.getDay();

        this.http.post(BASE_URL + '/question/answer',
        {timestamp:dates,description:this.newAnswer,ratingavg: 0,
          questionid:this.ques.id,userid: this.userId,isarchive:false}).subscribe(data=>{
        this.answer.push(data);
        this.showSuccess=true;


      });
        this.http.get(BASE_URL + '/notify/ans/'+this.ques.id).subscribe(data=>{
        });
      }
  }

  showEdit(index : any): void{
    this.show=true;
    const value = prompt("Edit the given answer", this.answer[index].description);
    this.answer[index].description=value;
    this.http.post(BASE_URL + '/question/answer/update',this.answer[index]).subscribe(data=>{
    })

  }

  deleteAnswer(index: any): void {
    const result =confirm('Are you sure?');

    if(result){
    const answerDelete = this.answer[index];
    this.http.post(BASE_URL + '/question/answer/delete',
    {id:answerDelete.id,name: answerDelete.name,
      timestamp: answerDelete.timestamp,description: answerDelete.description,
    isarchive: answerDelete.isarchive,ratingavg:answerDelete.ratingavg,
    userid:answerDelete.userid,questionid: answerDelete.questionid}).subscribe(data=>{
      if(data===true){
          this.answer.splice(index,1);
      }
    });
  }
}

resetAnswer():void{
  this.newAnswer=undefined;
  this.showError=false;
  this.showSuccess=false;
}

setAnswered(): void{
  this.http.get(BASE_URL + '/question/'+this.ques.id).subscribe(data=>{
    if(data===true){
      this.ques.answeredflag = true;
      localStorage.setItem('ques', JSON.stringify(this.ques));

    }

  });
}

}
