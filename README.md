# IntentAlarmClock
Test di un'applicazione che utilizza un'intent per settare una sveglia
Importante ricordare:
  <uses-permission android:name="com.android.alarm.permission.SET_ALARM"/> 
  prima di questo avevi inserito un permission sbagliato e per questo l'applicazione non funzionava
  infatti nemmeno android riconosceva la riciesta del permesso. (com.android.alarm...)
  
  per impostare i parametri della sveglia devi usare il metodo putExtra() in questo modo:
  Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                intent.putExtra(AlarmClock.EXTRA_MESSAGE,"Sveglia impostata dall'applicazione di Jacopo");
                intent.putExtra(AlarmClock.EXTRA_HOUR,18);
                intent.putExtra(AlarmClock.EXTRA_MINUTES,35);
