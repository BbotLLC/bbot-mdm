// main index.js

import { NativeModules } from 'react-native';

/**
 * @property {function} BbotMdm.isManaged   - Returns null if not managed, otherwise the managing app id
 */
const { BbotMdm } = NativeModules;

export default BbotMdm;
