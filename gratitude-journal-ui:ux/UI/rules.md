# UI Principles and Design Foundation – Gratitude Journal App

## 1. Purpose of UI Design

The Gratitude Journal App UI is designed to support **emotional clarity**, **ease of use**, and **consistency**, enabling users to feel calm and connected while using the product. The UI follows a **fixed, minimalist, mobile-first structure**.

---

## 2. Universal UI Principles (Strict Guidelines)

### 1. Simplicity

* One main action per screen
* Maximum 1 heading, 1 paragraph, and 2 buttons per screen
* No decorative images except one smiley emoji on Landing Page

### 2. Consistency

* Use only the defined color palette, font sizes, padding, and spacing throughout the app
* Button placement remains at the bottom center or bottom right (for floating actions)

### 3. Typography

* Use **Inter** font from Google Fonts only
* Font hierarchy:

    * Heading: 28px, weight 600, center-aligned
    * Subheading: 20px, weight 400, center-aligned
    * Body Text: 16px, weight 400
    * Button Text: 16px, weight 500, capitalized

### 4. Color Scheme (Fixed)

| Element                   | Color            | HEX Code  |
| ------------------------- | ---------------- | --------- |
| Background                | Soft Warm Orange | `#F98F63` |
| Primary Button Background | Golden Yellow    | `#FBC252` |
| Primary Button Text       | White            | `#FFFFFF` |
| Heading Text              | Dark Gray        | `#333333` |
| Input Field               | Light Gray       | `#F4F4F4` |
| Border Color              | Light Border     | `#DDDDDD` |
| Success Message           | Green            | `#28A745` |

### 5. Layout and Structure

* Layout is mobile-first using Flexbox
* Container width: 90% of viewport width, max 420px on desktop
* Vertical spacing: 24px between major sections
* Button height: 48px; full width or 80% width centered

### 6. Accessibility Rules

* All interactive elements use at least 16px font
* Maintain WCAG-compliant color contrast
* Buttons have a hover and active state (slightly darker or shadowed)
* Use `aria-labels` for buttons for accessibility

### 7. Whitespace Usage

* Minimum margin around text blocks: 16px
* Form inputs and buttons are vertically spaced by 24px
* Group related items into visual blocks (using light gray backgrounds)

### 8. Component Specifications

#### TextArea:

* Height: 120px
* Background: `#F4F4F4`
* Border radius: 8px
* Padding: 12px inside

#### Button:

* Border radius: 8px
* Height: 48px
* Text aligned center
* Shadow on hover

#### Emoji:

* One fixed emoji: 🙂 (used as SVG or image)
* Placement: Top center, above heading

---

## 3. Tools and Frameworks Used

* **Font**: Inter (via Google Fonts)
* **Styling**: TailwindCSS or CSS Variables with strict tokens
* **Layout Engine**: Flexbox with mobile-first responsive breakpoints

---

This finalized UI design system is ready to be applied across all screens.
No variation from this standard will be used to ensure visual and emotional consistency in the Gratitude Journal App.

Next: Begin with the **Landing Page UI using these rules**.
