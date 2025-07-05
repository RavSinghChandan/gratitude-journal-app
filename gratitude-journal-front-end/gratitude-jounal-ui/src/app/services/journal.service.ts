import { Injectable, inject } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

export interface GratitudeEntry{
  id: number
  content: string
  createdAt: string
}

@Injectable({
  providedIn: 'root'
})
export class JournalService {

private apiUrl = 'http://localhost:8080/api/journal'
private http = inject(HttpClient);

  addEntry(content: string) : Observable <GratitudeEntry>{
    return this.http.post<GratitudeEntry> (`${this.apiUrl}/add`, {content});
  }

  getAllEntries(): Observable<GratitudeEntry[]> {
    return this.http.get<GratitudeEntry[]> (`${this.apiUrl}/allEntries`);
  }
  
  deleteEntry(id: number): Observable<void> {
    return this.http.delete<void> (`${this.apiUrl}/delete/${id}`);
  }
}
