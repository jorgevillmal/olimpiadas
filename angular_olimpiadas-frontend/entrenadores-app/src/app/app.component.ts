import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'entrenadores-app';

  curso: string = 'curso-spring2';

  entrenador: string = 'Andrez Guzman';
}
