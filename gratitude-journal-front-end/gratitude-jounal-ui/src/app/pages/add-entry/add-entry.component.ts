import { Component, inject } from '@angular/core';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { JournalService } from '../../services/journal.service';

@Component({
  selector: 'app-add-entry',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './add-entry.component.html',
  styleUrl: './add-entry.component.css'
})
export class AddEntryComponent {
  entryContent: string = '';
  isLoading: boolean = false;
  showSuccess: boolean = false;

  private router = inject(Router);
  private journalService = inject(JournalService);

  onSubmit() {
    if (!this.entryContent.trim()) {
      return;
    }

    this.isLoading = true;
    this.journalService.addEntry(this.entryContent).subscribe({
      next: () => {
        this.isLoading = false;
        this.showSuccess = true;
        this.entryContent = '';
        
        // Hide success message after 3 seconds
        setTimeout(() => {
          this.showSuccess = false;
        }, 3000);
      },
      error: (error) => {
        this.isLoading = false;
        console.error('Error adding entry:', error);
        alert('Failed to add entry. Please try again.');
      }
    });
  }

  goBack() {
    this.router.navigate(['/']);
  }

  viewAllEntries() {
    this.router.navigate(['/entries']);
  }
}
