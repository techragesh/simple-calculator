import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CalculatorComponent } from './calculator/calculator.component';
import { FormsModule } from '@angular/forms';
import { CalculatorService } from './calculator.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, CalculatorComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, HttpClientModule],
  providers: [CalculatorService],
  bootstrap: [AppComponent],
})
export class AppModule {}
