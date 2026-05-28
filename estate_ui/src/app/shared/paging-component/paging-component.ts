import { Component, Input, input } from '@angular/core';
import { PagingTo } from '../models/PagingTo';

@Component({
  selector: 'app-paging-component',
  imports: [],
  templateUrl: './paging-component.html',
  styleUrl: './paging-component.css',
})
export class PagingComponent {

  @Input() pageDetail : PagingTo

  constructor(){
    this.pageDetail = {
      pageNumber : 21,
      pageSize : 100,
      totalElements : 20,
      totalPages : 5
    }
  }


}
