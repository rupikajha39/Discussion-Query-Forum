import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

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
  show = false;

  constructor(
    private router: Router,
    private http: HttpClient
    )
  {}

  ngOnInit(): void {
    this.userId = localStorage.getItem('id');
    this.ques = JSON.parse(localStorage.getItem('ques'));
    console.log(this.ques, this.userId);
    this.http.get('http://localhost:8080/question/answer/' + this.ques.id).subscribe(data => {
      this.answer = data;
      console.log(this.answer);
    });

  }


  answerInput(): void{
    this.showInput = ! this.showInput;
  }
  saveAnswer(): void{
      this.showError = false;
      this.showSuccess = false;
      if (this.newAnswer === undefined){
          this.showError = true;
      }
      else{
        const date = new Date;
        const dates = date.getFullYear() + '/' + date.getMonth() + '/' + date.getDay();

        this.http.post('http://localhost:8080/question/answer',
        {timestamp: dates, description: this.newAnswer, ratingavg: 0,
          questionid: this.ques.id, userid: this.userId, isarchive: false}).subscribe(data => {
        this.answer.push(data);
        this.showSuccess = true;


      });
        this.http.get('http://localhost:8080/notify/ans/' + this.ques.id).subscribe(data => {
                console.log(data);
              });
      }
  }

  showEdit(index: any): void{
    this.show = true;

    const value = prompt('Edit the given answer', this.answer[index].description);
    console.log(value);
    if(value!== null && value !==undefined && value!==''){
      this.answer[index].description = value;

      this.http.post('http://localhost:8080/question/answer/update', this.answer[index]).subscribe(data => {
        console.log(data);
      });
  }
  }

  deleteAnswer(index: any): void {
    const result = confirm('Are you sure?');

    if (result){
    const answerDelete = this.answer[index];
    this.http.post('http://localhost:8080/question/answer/delete',
    {id: answerDelete.id, name: answerDelete.name,
      timestamp: answerDelete.timestamp, description: answerDelete.description,
    isarchive: answerDelete.isarchive, ratingavg: answerDelete.ratingavg,
    userid: answerDelete.userid, questionid: answerDelete.questionid}).subscribe(data => {
      if (data === true){
          this.answer.splice(index, 1);
      }
    });
  }
}

resetAnswer(): void{
  this.newAnswer = undefined;
  this.showError = false;
  this.showSuccess = false;
}

setAnswered(): void{
  this.http.get('http://localhost:8080/question/' + this.ques.id).subscribe(data => {
    if (data === true){
      this.ques.answeredflag = true;
      // console.log(JSON.parse(JSON.stringify(this.ques)));
      localStorage.setItem('ques', JSON.stringify(this.ques));

    }

  });
}

}
