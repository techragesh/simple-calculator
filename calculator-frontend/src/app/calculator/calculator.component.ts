import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../calculator.service';

//CalculatorComponent is for calculating two numbers
@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css'],
})
export class CalculatorComponent implements OnInit {
  num1: any;
  num2: any;
  result: any;
  resultInput: any;

  constructor(private calulatorService: CalculatorService) {
    this.num1 = '';
    this.num2 = '';
    this.result = '0';
    this.resultInput = '';
  }

  ngOnInit(): void {}

  sum(): any {
    this.resultInput = '';
    this.formValidation();
    if(this.resultInput !== '') return;
    this.calulatorService.add(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => {
        console.log(JSON.stringify(error));
        this.resultInput = error.error.message;
      }
    );
    this.resultInput = this.num1 + ' + ' + this.num2;
  }

  sub(): any {
    this.resultInput = '';
    this.formValidation();
    if(this.resultInput !== '') return;
    this.calulatorService.sub(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => {
        console.log(JSON.stringify(error));
        this.resultInput = error.error.message;
      }
    );
    this.resultInput = this.num1 + ' - ' + this.num2;
  }

  multi(): any {
    this.resultInput = '';
    this.formValidation();
    if(this.resultInput !== '') return;
    this.calulatorService.multiply(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => {
        console.log(JSON.stringify(error));
        this.resultInput = error.error.message;
      }
    );
    this.resultInput = this.num1 + ' x ' + this.num2;
  }

  divide(): any {
    this.resultInput = '';
    this.formValidation();
    if(this.resultInput !== '') return;
    this.calulatorService.divide(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => {
        console.log(JSON.stringify(error));
        console.log(error.error.message);
        this.resultInput = error.error.message;
      }
    );
    this.resultInput = this.num1 + ' / ' + this.num2;
  }

  formValidation(): any {
    this.validateInput(this.num1);
    this.validateInput(this.num2);
  }

  validateInput(num: any) {
    if(num === null || num === '') {
      this.resultInput = "Input should not be empty";
    }
    this.result = '0';
  }

}
