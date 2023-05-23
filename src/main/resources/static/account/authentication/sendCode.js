var accountSid = 'ACa08f12cb040f497b8c9a949fba3f13ee';
var authToken = '7eeee9b83f51a40854d4015b5f511632';
var client = new Twilio(accountSid, authToken);

client.messages.create({
    body: 'Hello from Twilio!',
    from: '+84972495038',
    to: '+84369403807'
}).then(function(message) {
console.log('Message sent. SID:', message.sid);
}).catch(function(error) {
console.error('Error:', error);
});