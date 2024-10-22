import { Card, CardContent } from "@/components/ui/card"
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar"

interface UserStats {
  username: string
  imageUrl: string
  totalSolved: number
  easySolved: number
  mediumSolved: number
  hardSolved: number
}

export default function UserStatsCard({
  username = "JohnDoe",
  imageUrl = "/placeholder.svg?height=40&width=40",
  totalSolved = 350,
  easySolved = 200,
  mediumSolved = 100,
  hardSolved = 50
}: Partial<UserStats> = {}) {
  return (
    <Card className="w-full max-w-2xl shadow-lg hover:shadow-xl transition-shadow duration-300 ease-in-out">
      <CardContent className="p-6">
        <div className="flex flex-wrap items-center gap-4">
          <Avatar className="w-16 h-16 border-2 border-primary">
            <AvatarImage src={imageUrl} alt={username} />
            <AvatarFallback>{username?.slice(0, 2).toUpperCase()}</AvatarFallback>
          </Avatar>
          <div className="flex-grow">
            <h2 className="text-2xl font-bold text-primary">{username}</h2>
            <p className="text-muted-foreground">
              Total Solved: <span className="font-bold">{totalSolved}</span>
            </p>
          </div>
          <div className="flex items-center gap-3 mt-2 sm:mt-0">
            <StatBadge count={easySolved} color="bg-green-500" />
            <StatBadge count={mediumSolved} color="bg-yellow-500" />
            <StatBadge count={hardSolved} color="bg-red-500" />
          </div>
        </div>
      </CardContent>
    </Card>
  )
}

function StatBadge({ count = 0, color }: { count?: number; color: string }) {
  return (
    <div className={`flex items-center justify-center w-10 h-10 rounded-md ${color} text-white font-semibold text-sm`}>
      {count}
    </div>
  )
}