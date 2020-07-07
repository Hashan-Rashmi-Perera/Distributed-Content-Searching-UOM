import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs/operators';
import * as fileSaver from 'file-saver';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
  constructor(private http: HttpClient) {}

  title = 'search';
  searchTerm = '';

 dta=[
   {
    "name": "test1.mp3",
    "link": "https://music.hirufm.lk/download-1883-ac3d3fafed2f293aa9a163b8f90b4d83",
    "location": "node 1"
  },
  {
    "name": "test2.mp3",
    "link": "https://music.hirufm.lk/download-1883-ac3d3fafed2f293aa9a163b8f90b4d83",
    "location": "node 2"
  }
];

  serchList: any


  // tslint:disable-next-line: typedef
  onSearch(val:string) {
    //console.log(val);

    this.http.get<any>(environment.base_url + '?searchTerm=' + val).subscribe(
    data => this.serchList = data,
    error => console.error('There was an error!', error)
);

    this.serchList=this.dta

    console.log(this.serchList);

 /*return this.http
      .get(environment.base_url + '?searchTerm=' + val, {
        responseType: 'json',
      })
      .pipe(
        map((res) => {
          this.serchList=res;
var test = 'aaaa';
          return (JSON.stringify(test) );
        })
      );*/
  }

  // tslint:disable-next-line: typedef
  onDownlaod(val) {

    //console.log(val);
    this.downloadFileFromServer(val).subscribe((blob) => {
      if (blob !== null) {
        fileSaver.saveAs(blob, val + '.mp3');
      }
    },
    (err) => {
      console.log('HTTP Error', err);
    });
    this.searchTerm = '';

  }

  downloadFileFromServer(searchTerm: string): Observable<Blob> {
    return this.http
      .get(environment.base_url + '?searchTerm=' + searchTerm, {
        responseType: 'blob',
      })
      .pipe(
        map((res) => {
          return res;
        })
      );
  }
}
