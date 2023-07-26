import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { cuisineservice } from 'src/app/Services/cuisine.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent  {
  constructor(public router: Router) {
  }

  name!: string;
  medicine: string[] = ['American', 'Indian', 'British', 'Mexicon', 'chinese', 'Italian', 'Spanish', 'Polish'];
  onSearch(name: string) {
    if (name != undefined) {
      console.log('navigating to search url');
      let url = "/user/search/product/" + name;
      this.router.navigateByUrl(url);
    } else {
      console.log('please enter a name');
    }
  }

}
