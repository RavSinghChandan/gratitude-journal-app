import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { JournalService, GratitudeEntry } from '../../services/journal.service';

@Component({
  selector: 'app-all-entries',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './all-entries.component.html',
  styleUrl: './all-entries.component.css'
})
export class AllEntriesComponent implements OnInit {
  entries: GratitudeEntry[] = [];
  isLoading: boolean = false;
  error: string = '';

  constructor(
    private router: Router,
    private journalService: JournalService
  ) {}

  ngOnInit() {
    this.loadEntries();
  }

  loadEntries() {
    this.isLoading = true;
    this.error = '';
    
    this.journalService.getAllEntries().subscribe({
      next: (entries) => {
        this.entries = entries;
        this.isLoading = false;
      },
      error: (error) => {
        this.isLoading = false;
        this.error = 'Failed to load entries. Please try again.';
        console.error('Error loading entries:', error);
      }
    });
  }

  deleteEntry(id: number) {
    if (confirm('Are you sure you want to delete this entry?')) {
      this.journalService.deleteEntry(id).subscribe({
        next: () => {
          this.entries = this.entries.filter(entry => entry.id !== id);
        },
        error: (error) => {
          console.error('Error deleting entry:', error);
          alert('Failed to delete entry. Please try again.');
        }
      });
    }
  }

  formatDate(dateString: string): string {
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', {
      year: 'numeric',
      month: 'long',
      day: 'numeric',
      hour: '2-digit',
      minute: '2-digit'
    });
  }

  goBack() {
    this.router.navigate(['/']);
  }

  addNewEntry() {
    this.router.navigate(['/add']);
  }
}
