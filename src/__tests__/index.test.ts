import { MapMap } from '../index';

describe('greet', (): void => {
  test('if map has key, return true', (): void => {
    const mapmap = new MapMap<string, string>()
    mapmap.set('hoge', 'fuga');
    expect(mapmap.has('hoge')).toBe(true);
  });

  test('if map has not key, return false', (): void => {
    const mapmap = new MapMap<string, string>()
    mapmap.set('hoge', 'fuga');
    expect(mapmap.has('bar')).toBe(false);
  });

  class Key {
    private key: String;
    constructor(key: String) {
      this.key = key;
    }
    get(): String {
      return this.key;
    }
  }

  class Value {
    private value: String;
    constructor(value: String) {
      this.value = value;
    }
    get(): String {
      return this.value;
    }
  }

  test('yamashita', ():void => {
    const key1: Key = new Key('key 1');
    const key2: Key = new Key('key 3');
    const key3: Key = new Key('key 1');

    const value1: Value = new Value('value');
    const value2: Value = new Value('value');

    const mapmap: MapMap<Key, Value> = new MapMap<Key, Value>();

    expect(mapmap.has(key1)).toBe(false);
    expect(mapmap.has(key2)).toBe(false);
    expect(mapmap.has(key3)).toBe(false);

    mapmap.set(key1, value1);

    expect(mapmap.has(key1)).toBe(true);
    expect(mapmap.has(key2)).toBe(false);
    // expect(mapmap.has(key3)).toBe(true);

    // expect(mapmap.get(key1)).toBe(value1);
    // expect(mapmap.get(key2)).toBe(undefined);
    // expect(mapmap.get(key3)).toBe(value1);

    // expect(mapmap.delete(key1)).toBe(true);

    // expect(mapmap.has(key1)).toBe(false);
    // expect(mapmap.has(key2)).toBe(false);
    // expect(mapmap.has(key3)).toBe(false);

    // mapmap.set(key1, value1);
    // mapmap.set(key1, value2);

    // expect(mapmap.get(key1)).toBe(value2);
    // expect(mapmap.get(key2)).toBe(undefined);
    // expect(mapmap.get(key3)).toBe(value2);
  } );
});
