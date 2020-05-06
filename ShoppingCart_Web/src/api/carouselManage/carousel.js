import request from "@/utils/request.js";

/**
 * 获取轮播图
 * @param params
 * @returns {AxiosPromise}
 */
export function carouselList(params) {
    return request({
        url: "/carousel/list",
        method: "get",
        params: params
    });
}