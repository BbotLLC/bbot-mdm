# @bbot/bbot-mdm

## Getting started

`$ npm install @bbot/bbot-mdm --save`

### Mostly automatic installation

`$ react-native link @bbot/bbot-mdm`

## Usage
```javascript
import BbotMdm from '@bbot/bbot-mdm';

BbotMdm.isManaged().then(result => {
  console.log("Managed by: ", result);
});
```
