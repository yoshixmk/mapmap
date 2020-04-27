import { MapMap } from '../index';

describe('greet', (): void => {
  test('if map has key, return true', (): void => {
    const mapmap = new MapMap<string, string>()
    mapmap.set('hoge', 'fuga');
    expect(mapmap.has('hoge')).toBe(true);
  });

  // TODO
  // test('if map has not key, return false', (): void => {
  //   const mapmap = new MapMap<string, string>()
  //   mapmap.set('hoge', 'fuga');
  //   expect(mapmap.has('bar')).toBe(false);
  // });
});
