import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

import { ViewChild } from '@angular/core';

@Component({
  selector: 'upload-telefonia',
  templateUrl: './upload-telefonia.component.html',
  styleUrls: ['./upload-telefonia.component.scss']
})
export class UploadTelefoniaComponent implements OnInit {

  @ViewChild('myInput') myInputVariable: any;

  constructor(private http : HttpClient) { }

  ngOnInit() {
  }

  reset() {
    console.log(this.myInputVariable.nativeElement.files);
    this.myInputVariable.nativeElement.value = "";
    console.log(this.myInputVariable.nativeElement.files);
  }

  inputFileChange(event) {
    
    if(event.target.files && event.target.files[0]) {
      const myFile = event.target.files[0];
      
      //console.log(myFile.size/1024/1024 + ' MB');

      const formData = new FormData();
      formData.append('file', myFile);

      this.http.post('http://localhost:8091/service/file', formData).subscribe(resposta => alert("Upload realizado com sucesso."));

      this.reset();
    }

  }

}
