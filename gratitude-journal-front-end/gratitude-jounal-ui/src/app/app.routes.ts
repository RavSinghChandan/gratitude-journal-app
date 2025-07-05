import { Routes } from '@angular/router';
import { LandingComponent } from './pages/landing/landing.component';
import { AddEntryComponent } from './pages/add-entry/add-entry.component';
import { AllEntriesComponent } from './pages/all-entries/all-entries.component';

export const routes: Routes = [
  { path: '', component: LandingComponent },
  { path: 'add', component: AddEntryComponent },
  { path: 'entries', component: AllEntriesComponent },
  { path: '**', redirectTo: '' }
];
