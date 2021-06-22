# exchange-api with caching
## using RestTemplate and spring caching

first you have to register for [exchange rate API](https://www.exchangerate-api.com/)
than you will get a URL which will provide us USD exchange rate compare to about 160 countries
this URL should look like same that:
>https://v6.exchangerate-api.com/v6/ {{your API key here}}/latest/USD

as you click on this link we'll get all th einformation in a JSON format:

```json
{"result":"success",
"documentation":"https://www.exchangerate-api.com/docs",
"terms_of_use":"https://www.exchangerate-api.com/terms",
"time_last_update_unix":1624233601,"time_last_update_utc":"Mon,
21 Jun 2021 00:00:01 +0000","time_next_update_unix":1624320001,
"time_next_update_utc":"Tue, 22 Jun 2021 00:00:01 +0000",
"base_code":"USD",
"conversion_rates":{"USD":1,"AED":3.6725,"AFN":78.7402,"ALL":103.1460,"AMD":513.7300,"ANG":1.7900,"AOA":646.9167,"ARS":95.4747,"AUD":1.3322,"AWG":1.7900,"AZN":1.7015,"BAM":1.6458,"BBD":2.0000,"BDT":84.9542,"BGN":1.6457,"BHD":0.3760,"BIF":1965.9735,"BMD":1.0000,"BND":1.3441,"BOB":6.9149,"BRL":5.0118,"BSD":1.0000,"BTN":74.1011,"BWP":10.7696,"BYN":2.5170,"BZD":2.0000,"CAD":1.2421,"CDF":1990.6124,"CHF":0.9215,"CLP":739.1964,"CNY":6.4513,"COP":3732.1934,"CRC":619.3260,"CUC":1.0000,"CUP":25.7500,"CVE":92.7857,"CZK":21.5954,"DJF":177.7210,"DKK":6.2778,"DOP":57.1417,"DZD":134.4267,"EGP":15.6679,"ERN":15.0000,"ETB":43.7515,"EUR":0.8415,"FJD":2.0616,"FKP":0.7228,"FOK":6.2778,"GBP":0.7228,"GEL":3.1638,"GGP":0.7228,"GHS":5.8010,"GIP":0.7228,"GMD":51.9663,"GNF":9832.5777,"GTQ":7.7373,"GYD":209.2741,"HKD":7.7637,"HNL":24.0616,"HRK":6.3401,"HTG":90.9697,"HUF":301.1764,"IDR":14494.9005,"ILS":3.3005,"IMP":0.7228,"INR":74.1023,"IQD":1460.6644,"IRR":41960.2603,"ISK":123.0485,"JMD":150.5962,"JOD":0.7090,"JPY":110.2014,"KES":107.9094,"KGS":84.6343,"KHR":4083.4749,"KID":1.3327,"KMF":413.9806,"KRW":1134.5215,"KWD":0.2996,"KYD":0.8333,"KZT":428.6272,"LAK":9469.6970,"LBP":1507.5000,"LKR":198.4076,"LRD":171.7328,"LSL":14.2807,"LYD":4.4704,"MAD":8.9184,"MDL":17.7705,"MGA":3781.5029,"MKD":51.6833,"MMK":1648.7317,"MNT":2850.0225,"MOP":7.9967,"MRU":36.1702,"MUR":40.8921,"MVR":15.4211,"MWK":799.8800,"MXN":20.6163,"MYR":4.1359,"MZN":63.5770,"NAD":14.2807,"NGN":416.9239,"NIO":34.9895,"NOK":8.6508,"NPR":118.5617,"NZD":1.4387,"OMR":0.3845,"PAB":1.0000,"PEN":3.9245,"PGK":3.5152,"PHP":48.4953,"PKR":157.4600,"PLN":3.8370,"PYG":6729.7618,"QAR":3.6400,"RON":4.1362,"RSD":98.8142,"RUB":72.4144,"RWF":1003.6106,"SAR":3.7500,"SBD":7.9149,"SCR":15.0978,"SDG":434.4627,"SEK":8.6028,"SGD":1.3441,"SHP":0.7228,"SLL":10264.7789,"SOS":579.1041,"SRD":21.0619,"SSP":177.4827,"STN":20.6162,"SYP":1259.2276,"SZL":14.2807,"THB":31.5742,"TJS":11.3131,"TMT":3.5000,"TND":2.7701,"TOP":2.2328,"TRY":8.7351,"TTD":6.7902,"TVD":1.3327,"TWD":27.7657,"TZS":2314.9712,"UAH":27.2168,"UGX":3529.9417,"UYU":43.7344,"UZS":10484.2857,"VES":3138598.8100,"VND":23124.4074,"VUV":109.9502,"WST":2.5448,"XAF":551.9741,"XCD":2.7000,"XDR":0.7004,"XOF":551.9741,"XPF":100.4154,"YER":250.3756,"ZAR":14.2812,"ZMW":22.5487}}
```

as we see, we don't need all of this information which just indicate us that the proccess succeded and addintional info .
we want only the last line: **"conversion_rates":{"USD":1...**
