import request from "@/utils/request.js";

/**
 * 获取商品
 * @param params
 * @returns {AxiosPromise}
 */
export function goods(params) {
  return request({
    url: "/goods/getGoodsList",
    method: "post",
    data: params
  });
}

/**
 * 修改商品
 * @param params
 * @returns {AxiosPromise}
 */
export function saveGoods(params) {
  return request({
      url: "/goods/saveGoods",
      method: "post",
      data: params
  });
}

/**
 * 查询商品
 * @param params
 * @returns {AxiosPromise}
 */
export function getGoods(params) {
  return request({
      url: "/goods/getGoodsById",
      method: "get",
      params: params
  });
}

/**
 * 修改商品状态
 * @param params
 * @returns {AxiosPromise}
 */
export function updateGoodsState(params) {
  return request({
      url: "/goods/updateState",
      method: "post",
      data: params
  });
}