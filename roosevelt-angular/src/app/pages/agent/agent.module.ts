import { NgModule } from '@angular/core';

import { ThemeModule } from '../../@theme/theme.module';
import { AgentRoutingModule, routedComponents } from './agent-routing.module';

@NgModule({
  imports: [
    ThemeModule,
    AgentRoutingModule,
  ],
  declarations: [
    ...routedComponents,
  ],
})
export class AgentModule { }
