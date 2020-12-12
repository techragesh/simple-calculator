import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class CalculatorService {
  private baseUrl = 'http://localhost:8090/api/v1/calc';

  constructor(private http: HttpClient) {}

  add(num1: number, num2: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/add/${num1}/${num2}`);
  }

  sub(num1: number, num2: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/sub/${num1}/${num2}`);
  }

  multiply(num1: number, num2: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/multiply/${num1}/${num2}`);
  }

  divide(num1: number, num2: number): Observable<any> {
    return this.http.get(`${this.baseUrl}/divide/${num1}/${num2}`);
  }
}
