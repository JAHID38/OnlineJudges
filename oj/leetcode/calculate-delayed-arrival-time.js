/**
 * @param {number} arrivalTime
 * @param {number} delayedTime
 * @return {number}
 */
var findDelayedArrivalTime = function(arrivalTime, delayedTime) {
    let total = arrivalTime + delayedTime;
    return total > 23 ? Math.abs(24 - total) : total;
};