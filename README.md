# @bbot/bbot-mdm

Simple utility for determining if the device is managed

## Getting started

`$ npm install BbotLLC/bbot-mdm --save`

### Mostly automatic installation

`$ react-native link @bbot/bbot-mdm`

## Usage
```javascript
import BbotMdm from '@bbot/bbot-mdm';

BbotMdm.isManaged().then(result => {
  console.log("Managed by: ", result);
});
```
