import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { AdminRoutingModule, routedComponents } from './admin-routing.module';

import { HttpClientModule } from '@angular/common/http';

import { UploadTelefoniaComponent } from './upload-telefonia/upload-telefonia.component';

@NgModule({
  imports: [
    ThemeModule,
    AdminRoutingModule,
    HttpClientModule,
  ],
  declarations: [
    ...routedComponents,
    UploadTelefoniaComponent,
  ],
})
export class AdminModule { }
