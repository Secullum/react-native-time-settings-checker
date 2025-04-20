declare module TimeSettingsChecker{
    export function getAutomaticDateTimeEnabledAsync() : Promise<boolean>
    export function getAutomaticTimezoneEnabledAsync() : Promise<boolean>
}

export default TimeSettingsChecker;
