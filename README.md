# NewsApp-Compose
A news app developed for learning and practicing modern Android app development techniques and libraries.


# Screenshots

<table>
  <tr>
    <td align="center">
      <img src="https://github.com/AzizbekLive/NewsApp-Compose/assets/120745929/282aa63c-ecd2-4e92-bed3-40f196c5e2ec" width="200" alt="Screenshot 1">
    </td>
    <td align="center">
      <img src="https://github.com/AzizbekLive/NewsApp-Compose/assets/120745929/fa570a20-b050-4d9a-97a2-9d5215db10a0" width="200" alt="Screenshot 2">
    </td>
    <td align="center">
      <img src="https://github.com/AzizbekLive/NewsApp-Compose/assets/120745929/94a6b16c-62fb-4cab-82cc-8a05d9184398" width="200" alt="Screenshot 3">
    </td>
  </tr>
  <tr>
    <td align="center">
      Screenshot 1
    </td>
    <td align="center">
      Screenshot 2
    </td>
    <td align="center">
      Screenshot 3
    </td>
  </tr>
</table>

<table>
  <tr>
    <td align="center">
      <img src="https://github.com/AzizbekLive/NewsApp-Compose/assets/120745929/f769a9fc-5806-4cf5-bfba-d075694300bb" width="200" alt="Screenshot 4">
    </td>
    <td align="center">
      <img src="https://github.com/AzizbekLive/NewsApp-Compose/assets/120745929/3eee5b54-a6ad-4f0d-86b8-1266dcd99771" width="200" alt="Screenshot 5">
    </td>
    <td align="center">
      <img src="https://github.com/AzizbekLive/NewsApp-Compose/assets/120745929/a78d341f-a4fd-403e-ac21-2442a8a38482" width="200" alt="Screenshot 6">
    </td>
  </tr>
  <tr>
    <td align="center">
      Screenshot 4
    </td>
    <td align="center">
      Screenshot 5
    </td>
    <td align="center">
      Screenshot 6
    </td>
  </tr>
</table>

## Architecture

The app is designed following the Clean Architecture principles, separating the application into different layers:

- **Presentation Layer**: Responsible for handling UI-related tasks and user interactions.
- **Domain Layer**: Contains the business logic and use cases of the application.
- **Data Layer**: Handles data sources, including remote API calls.

The Model-View-Intent (MVI) architecture is used in the presentation layer to manage UI state and user interactions efficiently.

## Features

- MVI (Model-View-Intent) architecture
- Clean architecture
- Kotlin Coroutines for asynchronous programming
- Retrofit 2 for network requests
- Dagger Hilt for dependency injection
- Voyager for navigation
- Shared Preferences for storing user preferences
- Horizontal ViewPager for displaying news articles
- ...
