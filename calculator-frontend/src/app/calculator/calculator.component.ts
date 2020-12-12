import { Component, OnInit } from '@angular/core';
import { CalculatorService } from '../calculator.service';

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
    this.calulatorService.add(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => {
        console.log(JSON.stringify(error));
        this.result = error.error.message;
      }
    );
    this.resultInput = this.num1 + ' + ' + this.num2;
  }

  sub(): any {
    this.calulatorService.sub(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => console.log(error)
    );
    this.resultInput = this.num1 + ' - ' + this.num2;
  }
  multi(): any {
    this.calulatorService.multiply(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => console.log(error)
    );
    this.resultInput = this.num1 + ' x ' + this.num2;
  }
  divide(): any {
    this.calulatorService.divide(this.num1, this.num2).subscribe(
      (data) => {
        console.log(data);
        this.result = data.result;
      },
      (error) => console.log(error)
    );
    this.resultInput = this.num1 + ' / ' + this.num2;
  }
}
